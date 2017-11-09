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

            foreach (var employee in _employees)
            {
                Console.WriteLine($"Employee: {employee.Name}");
                employee.Col.IfSome(col => Console.WriteLine($"Col: {col}"));
                employee.Job.IfSome(job => Console.WriteLine($"Job: {job}"));
                employee.Sallery.IfSome(sal => Console.WriteLine($"Sallery: {sal}"));
                Console.WriteLine();
            }
        }

        private void ProcessInput()
        {
            foreach (var line in _input)
            {
                if (!line.StartsWith("::EXT::"))
                    _employees.Add(new Employee(line));
                else
                    _employees.Last().AddExtension(line);
            }
        }

        private static List<string> ReadFile(string path)
        {
            return File.ReadAllLines(path).ToList();
        }

        private readonly List<string> _input;
        private readonly List<Employee> _employees;
    }
}
