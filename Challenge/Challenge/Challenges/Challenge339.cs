using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;
using Challenge.Challenges.Chal339;

namespace Challenge.Challenges
{
    /// <summary>
    /// https://www.reddit.com/r/dailyprogrammer/comments/7b5u96/20171106_challenge_339_easy_fixedlength_file/
    /// </summary>
    internal class Challenge339 : Challenge
    {
        public Challenge339()
        {
            _input = ReadFile("Resources/Challenge339.txt");
            _employees = new List<Employee>();
        }

        public override void Execute()
        {
            Console.WriteLine($"Lines: {_input.Count}");

            ProcessInput();

            Console.WriteLine($"Employees: {_employees.Count}");
        }

        private void ProcessInput()
        {
            foreach (var line in _input)
            {
                if (line.StartsWith("::EXT::"))
                    continue;
                _employees.Add(new Employee(line));
            }
        }

        private static List<string> ReadFile(string path)
        {
            return File.ReadAllLines(path).ToList();
        }

        private readonly List<string> _input;
        private List<Employee> _employees;
    }
}
