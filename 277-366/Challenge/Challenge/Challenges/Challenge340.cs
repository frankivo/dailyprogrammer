using System;
using System.Collections.Generic;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/7cnqtw/20171113_challenge_340_easy_first_recurring/
    /// </summary>
    internal class Challenge340 : Challenge
    {
        public override void Execute() =>_input.ForEach(Solve);

        private static void Solve(string input)
        {
            var map = new Dictionary<char, int>();

            for (var i = 0; i < input.Length; i++)
            {
                var c = input[i];

                if (map.TryGetValue(c, out var index))
                {
                    Console.WriteLine($"Not first {c}, first occurance was {index}");
                    break;
                }

                map.Add(c, i);
            }
        }

        private readonly List<string> _input = new List<string>
        {
            "ABCDEBC",
            "IKEUNFUVFVPXLJOUDJVZGQHLBHGXIW*l1J?)yn%R[}9~1\"=k7]9;0[$",
            "The quick brown fox jumps over the lazy dog!".Replace(" ", string.Empty)
        };
    }
}
