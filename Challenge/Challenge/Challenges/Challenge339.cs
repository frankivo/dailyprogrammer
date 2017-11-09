using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Challenge.Challenges
{
    internal class Challenge339 : Challenge
    {
        public Challenge339() => _input = ReadFile("Resources/Challenge339.txt");

        public override void Execute()
        {
            Console.WriteLine($"Lines: {_input.Count}");
        }

        private static List<string> ReadFile(string path)
        {
            return File.ReadAllLines(path).ToList();
        }

        private readonly List<string> _input;
    }
}
