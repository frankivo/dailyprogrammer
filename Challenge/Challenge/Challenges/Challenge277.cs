using System;
using System.Collections.Generic;
using System.Linq;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/4uhqdb/20160725_challenge_277_easy_simplifying_fractions/
    /// </summary>
    internal class Challenge277 : Challenge
    {
        public override void Execute()
        {
            var input = GetInput().First();
        }

        private static IEnumerable<(int nummerator, int denominator)> GetInput()
        {
            const string input = "4 8\r\n1536 78360\r\n51478 5536\r\n46410 119340\r\n7673 4729\r\n4096 1024";
            return input.Split(new[] { "\r\n" }, StringSplitOptions.None)
                .Select(x => x.Split(' '))
                .Select(y => (nummerator: int.Parse(y[0]), denominator: int.Parse(y[1])));
        }
    }
}
