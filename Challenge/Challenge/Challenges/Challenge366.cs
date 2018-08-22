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
        public override void Execute()
        {
            Challenge();
            Console.WriteLine();
            Bonus();
        }

        private static void Challenge() => GetInput().ToList().ForEach(i => Funnel(i.haystack, i.needle));

        private static void Bonus() => JsonConvert.DeserializeObject<List<string>>(Bonus1).ForEach(Bonus);

        private static IEnumerable<(string haystack, string needle)> GetInput()
        {
            var input = JsonConvert.DeserializeObject<List<Dictionary<string, string>>>(Input);
            foreach (var i in input)
                yield return (i["hay"], i["needle"]);
        }

        private static void Funnel(string haystack, string needle)
        {
            var options = FindOptions(haystack);
            var result = Funnel(options, needle);
            Console.WriteLine($@"funnel(""{haystack}"", ""{needle}"") => {result}");
        }

        private static bool Funnel(IEnumerable<string> options, string needle) => options.Any(o => o.Equals(needle));

        private static void Bonus(string haystack)
        {
            var options = string.Join(", ", FindOptions(haystack).Select(o => $@"""[{o}]"""));
            Console.WriteLine($@"bonus(""{haystack}"") => {options}");
        }

        private static IEnumerable<string> FindOptions(string hay) =>
            new HashSet<string>(hay.Select((t, i) => hay.Substring(0, i) + hay.Substring(i + 1)));

        private const string Input = @"[
                { ""hay"": ""leave"", ""needle"": ""eave"" },
                { ""hay"": ""reset"", ""needle"": ""rest"" },
                { ""hay"": ""dragoon"", ""needle"": ""dragon"" },
                { ""hay"": ""eave"", ""needle"": ""leave"" },
                { ""hay"": ""sleet"", ""needle"": ""lets"" },
                { ""hay"": ""skiff"", ""needle"": ""ski"" }
              ]";

        private const string Bonus1 = @"[ ""dragoon"", ""boats"", ""affidavit"" ]";
    }
}
