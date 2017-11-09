using System;

namespace Challenge.Challenges.Chal339
{
    internal class Employee
    {
        private const string SearchCol = "::EXT::COL";
        private const string SearchJob = "::EXT::JOB";
        private const string SearchSal = "::EXT::SAL";

        public Employee(string raw)
        {
            Name = raw.Substring(0, 19).Trim();
            Age = int.Parse(raw.Substring(20, 2));

            var year = int.Parse(raw.Substring(22, 2));
            var month = int.Parse(raw.Substring(24, 2));
            var day = int.Parse(raw.Substring(26, 2));
            BirthDate = new DateTime(year, month, day);
        }

        public void AddExtension(string raw)
        {
            if (raw.StartsWith(SearchCol))
                Col = raw.Substring(SearchCol.Length).Trim();
            else if (raw.StartsWith(SearchJob))
                Job = raw.Substring(SearchJob.Length).Trim();
            else if (raw.StartsWith(SearchSal))
                Sallery = int.Parse(raw.Substring(SearchSal.Length).Trim());
            else
                throw new ArgumentException(nameof(raw));
        }

        public string Name { get; }

        public int Age { get; }

        public DateTime BirthDate { get; }

        public string Col { get; private set; }

        public string Job { get; private set; }

        public int Sallery { get; private set; }
    }
}
