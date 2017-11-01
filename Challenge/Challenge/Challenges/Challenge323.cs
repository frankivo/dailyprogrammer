using System;
using System.Collections.Generic;
using System.Linq;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/6melen/20170710_challenge_323_easy_3sum/
    /// </summary>
    internal class Challenge323 : Challenge
    {
        public override void Execute()
        {
            GetInput().ForEach(i => Console.Write($" {i}"));
            Console.WriteLine();
        }

        private static List<int> GetInput() => Input.Split(' ').Select(int.Parse).ToList();

        private const string Input = "4 5 -1 -2 -7 2 -5 -3 -7 -3 1 -1 -6 -3 -7 5 -8 2 -8 1 -5 -1 -4 2 9 -9 -6 -1 -7";
    }
}
