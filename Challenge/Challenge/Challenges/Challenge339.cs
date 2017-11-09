using Challenge.Challenges.Chal339;
using LanguageExt.UnsafeValueAccess;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;

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

            _employees.ForEach(WriteEmployee);

            var emp = GetHighestSallery();
            var sal = emp.Sallery.ValueUnsafe().ToString("N0", new CultureInfo("en-US"));

            Console.WriteLine($"{emp.Name}, ${sal}");
        }

        private Employee GetHighestSallery() => _employees.Where(e => e.Sallery.IsSome).OrderBy(e => e.Sallery).Last();

        private static void WriteEmployee(Employee emp)
        {
            Console.WriteLine($"Employee: {emp.Name}");
            emp.Col.IfSome(col => Console.WriteLine($"Col: {col}"));
            emp.Job.IfSome(job => Console.WriteLine($"Job: {job}"));
            emp.Sallery.IfSome(sal => Console.WriteLine($"Sallery: {sal}"));
            Console.WriteLine();
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
