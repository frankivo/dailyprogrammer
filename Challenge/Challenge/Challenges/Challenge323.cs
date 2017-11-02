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
        private class ResultType : HashSet<(int, int, int)> {}

        public override void Execute()
        {
            GetInput().ForEach(i =>
            {
                Console.WriteLine("Input: ");
                i.ForEach(j => Console.Write($"{j} "));
                Console.WriteLine();

                var res = SolveInput(i);
                PrintResult(res);

                Console.WriteLine();
            });
        }

        private ResultType SolveInput(List<int> input)
        {
            var rs = new ResultType();

            for (var a = 0; a < input.Count; a++)
            {
                var first = input[a];

                for (var b = 0; b < input.Count; b++)
                {
                    if (b == a) continue;
                    var second = input[b];

                    for (var c = 0; c < input.Count; c++)
                    {
                        if (c == a || c == b) continue;
                        var third = input[c];

                        if (first + second + third != 0) continue;
                        rs.Add(Sort(first, second, third));
                    }
                }
            }

            return rs;
        }

        private void PrintResult(ResultType res)
        {
            Console.WriteLine("Output: ");
            foreach (var r in res.OrderBy(i => i.Item1).ThenBy(i => i.Item2).ThenBy(i => i.Item3))
            {
                Console.WriteLine($"SOL {r.Item1} {r.Item2} {r.Item3}");
            }
        }

        private (int, int, int) Sort(params int[] items)
        {
            var sorted = items.OrderBy(i => i).ToList();
            return (sorted[0], sorted[1], sorted[2]);
        }

        private static List<List<int>> GetInput()
        {
            var lines = new List<List<int>>();
            Input.ForEach(l => lines.Add(l.Split(' ').Select(int.Parse).ToList()));
            return lines;
        }

        private static readonly List<string> Input = new List<string>
        {
            "9 -6 -5 9 8 3 -4 8 1 7 -4 9 -9 1 9 -9 9 4 -6 -8",
            "4 5 -1 -2 -7 2 -5 -3 -7 -3 1",
            "-1 -6 -3 -7 5 -8 2 -8 1",
            "-5 -1 -4 2 9 -9 -6 -1 -7"
        };
    }
}
