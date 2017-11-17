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
        public override void Execute() => GetInput().ToList().ForEach(Solve);

        private static void Solve(ValueTuple<int, int> input) // Meh, no names here
        {
            var num = input.Item1;
            var den = input.Item2;

            for (var i = num; i > 1; i--)
            {
                if (IsFraction(num, i) || IsFraction(den, i)) continue;
                Console.WriteLine($"{num} {den} = {num / i} {den / i}");
                break;
            }
        }

        private static bool IsFraction(int a, int b) => a % b != 0;

        private static IEnumerable<(int nummerator, int denominator)> GetInput() =>
            "4 8\r\n1536 78360\r\n51478 5536\r\n46410 119340\r\n7673 4729\r\n4096 1024"
                .Split(new[] {"\r\n"}, StringSplitOptions.None)
                .Select(x => x.Split(' '))
                .Select(y => ( int.Parse(y[0]), int.Parse(y[1])));
    }
}
