using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/
    /// </summary>
    internal class Challenge366 : Challenge
    {
        public override void Execute() =>
            GetInput().ForEach(d => Funnel(d.Hay, d.Needles));

        private static List<FunnelData> GetInput() =>
            JsonConvert.DeserializeObject<List<FunnelData>>(Input);

        private static void Funnel(string hay, params string[] needles) =>
            needles.ToList().ForEach(needle => Console.WriteLine($"{hay} -- {needle} -- {Funnel(hay, needle)}"));

        private static bool Funnel(string hay, string needle) =>
            FindOptions(hay).Where(o => o.Equals(needle)).ToList().Count > 0;

        // ReSharper disable once ReturnTypeCanBeEnumerable.Local
        private static List<string> FindOptions(string hay) =>
            hay.Select((t, i) => hay.Substring(0, i) + hay.Substring(i + 1)).ToList();

        private const string Input = @"[
                { ""hay"": ""leave"", ""needles"": [ ""eave"" ] },
                { ""hay"": ""reset"", ""needles"": [ ""rest"" ] },
                { ""hay"": ""boats"", ""needles"": [ ""oats"", ""bats"", ""bots"", ""boas"", ""boat"" ] }
              ]";

        private struct FunnelData
        {
            public string Hay;
            public string[] Needles;
        }
    }
}
