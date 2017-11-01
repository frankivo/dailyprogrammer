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
            Console.ReadLine();
        }

        private List<int> GetInput() => input.Split(' ').Select(i => int.Parse(i)).ToList();

        private string input = "9 -6 -5 9 8 3 -4 8 1 7 -4 9 -9 1 9 -9 9 4 -6 -8";
    }
}
