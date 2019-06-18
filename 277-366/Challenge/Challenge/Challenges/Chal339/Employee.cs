using System;
using System.Collections.Generic;

namespace Challenge.Challenges.Chal339
{
    internal class Employee
    {
        private const int NameLength = 20;
        private const int AgeLength = 2;
        private const int YearLength = 2;
        private const int MonthLength = 2;
        private const int DayLength = 2;
        private readonly Dictionary<string, string> _extensions;

        public Employee(string raw)
        {
            var index = 0;

            Name = raw.Substring(index, NameLength).Trim();
            Age = int.Parse(raw.Substring(index += NameLength, AgeLength));

            var year = int.Parse(raw.Substring(index += AgeLength, YearLength));
            var month = int.Parse(raw.Substring(index += YearLength, MonthLength));
            var day = int.Parse(raw.Substring(index + MonthLength, DayLength));
            BirthDate = new DateTime(year, month, day);

            _extensions = new Dictionary<string, string>();
        }

        public void AddExtension(string raw)
        {
            var key = raw.Substring(7, 3);
            var value = raw.Substring(11);
            _extensions.Add(key, value);
        }

        public string Name { get; }

        public int Age { get; }

        public DateTime BirthDate { get; }

        public bool HasExtension(string key) => _extensions.ContainsKey(key);

        public string GetExtension(string key) => _extensions[key];
    }
}
