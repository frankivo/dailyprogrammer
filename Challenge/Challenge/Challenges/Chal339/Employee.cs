using System;

namespace Challenge.Challenges.Chal339
{
    internal class Employee
    {
        public Employee(string raw)
        {
            var index = 0;

            Name = raw.Substring(0, 19).Trim();
            Age = int.Parse(raw.Substring(20, 2));

            var year = int.Parse(raw.Substring(22, 2));
            var month = int.Parse(raw.Substring(24, 2));
            var day = int.Parse(raw.Substring(26, 2));
            BirthDate = new DateTime(year, month, day);
        }

        public string Name { get; }

        public int Age { get; }

        public DateTime BirthDate { get; }
    }
}
