using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/
    /// </summary>
    public class Challenge366 : Challenge
    {
        public override void Execute()
        {
            Challenge();
            Console.WriteLine();
            Bonus();
        }

        private static void Challenge()
        {
            foreach (var (haystack, needle) in GetInput())
            {
                Console.WriteLine($@"funnel(""{haystack}"", ""{needle}"") => {Funnel(haystack, needle)}");
            }
        }

        private static void Bonus() => JsonConvert.DeserializeObject<List<string>>(Bonus1).ForEach(Bonus);

        private static IEnumerable<(string haystack, string needle)> GetInput()
        {
            var input = JsonConvert.DeserializeObject<List<Dictionary<string, string>>>(Input);
            foreach (var i in input)
                yield return (i["hay"], i["needle"]);
        }

        /// <summary>
        /// Given two strings of letters, determine whether the second can be made from the first by removing one letter. The remaining letters must stay in the same order.
        /// </summary>
        /// <param name="haystack">Search in here.</param>
        /// <param name="needle">Search this..</param>
        /// <returns>True if needle can be made from the haystrack minus one letter. False otherwise.</returns>
        public static bool Funnel(string haystack, string needle) => GetOptions(haystack).Contains(needle);

        private static void Bonus(string haystack)
        {
            var options = string.Join(", ", GetOptions(haystack).Select(o => $@"""[{o}]"""));
            Console.WriteLine($@"bonus(""{haystack}"") => {options}");
        }

        /// <summary>
        /// Get all possible correct possible positive needles.
        /// </summary>
        /// <param name="hay">Haystack to retrieve needles for.</param>
        /// <returns>List of unique valid needles.</returns>
        protected static IEnumerable<string> GetOptions(string hay) =>
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
