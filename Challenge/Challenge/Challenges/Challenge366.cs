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
            GetInput().ForEach(d => Funnel(d.Hay, d.Needle));

        private static List<FunnelData> GetInput() =>
            JsonConvert.DeserializeObject<List<FunnelData>>(Input);

        private static void Funnel(string hay, string needle) =>
            Log(hay, needle, Funnel(FindOptions(hay), needle));

        private static bool Funnel(IEnumerable<string> options, string needle) =>
            options.Any(o => o.Equals(needle));

        private static void Log(string hay, string needle, bool result) =>
            Console.WriteLine($@"funnel(""{hay}"", ""{needle}"") => {result}");

        private static IEnumerable<string> FindOptions(string hay) =>
            hay.Select((t, i) => hay.Substring(0, i) + hay.Substring(i + 1)).ToList();

        private const string Input = @"[
                { ""hay"": ""leave"", ""needle"": ""eave"" },
                { ""hay"": ""reset"", ""needle"": ""rest"" },
                { ""hay"": ""dragoon"", ""needle"": ""dragon"" },
                { ""hay"": ""eave"", ""needle"": ""leave"" },
                { ""hay"": ""sleet"", ""needle"": ""lets"" },
                { ""hay"": ""skiff"", ""needle"": ""ski"" },
                { ""hay"": ""boats"", ""needle"": ""oats"" }
              ]";

        private struct FunnelData
        {
            public string Hay;
            public string Needle;
        }
    }
}
