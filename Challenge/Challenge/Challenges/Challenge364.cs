using System;
using System.Collections.Generic;
using System.Linq;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/8s0cy1/20180618_challenge_364_easy_create_a_dice_roller/
    /// </summary>
    internal class Challenge364 : Challenge
    {
        private readonly Random _random = new Random();

        public override void Execute()
        {
            while (true)
            {
                var (dice, sides) = GetInput();
                var output = Calculate(dice, sides).ToList();
                Console.WriteLine($"{output.Sum()}: {string.Join(" ", output.ToArray())}");
            }
        }

        private static (int dice, int sides) GetInput()
        {
            Console.WriteLine("Use format '123d123':");

            var input = Console.ReadLine();
            var parsed = input?.Split('d');

            if (parsed == null || parsed.Length != 2) throw new ArgumentException("Invalid format.");

            return (int.Parse(parsed.First()), int.Parse(parsed.Last()));
        }

        private IEnumerable<int> Calculate(int dice, int sides) => Enumerable.Range(0, dice).Select(i => _random.Next(1, sides));
    }
}
