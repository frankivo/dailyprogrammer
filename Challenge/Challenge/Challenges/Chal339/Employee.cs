using System;

namespace Challenge.Challenges.Chal339
{
    internal class Employee
    {
        private const string SearchCol = "::EXT::COL";
        private const string SearchJob = "::EXT::JOB";
        private const string SearchSal = "::EXT::SAL";
        private const int NameLength = 20;
        private const int AgeLength = 2;
        private const int YearLength = 2;
        private const int MonthLength = 2;
        private const int DayLength = 2;

        public Employee(string raw)
        {
            var index = 0;

            Name = raw.Substring(index, NameLength).Trim();
            Age = int.Parse(raw.Substring(index += NameLength, AgeLength));

            var year = int.Parse(raw.Substring(index += AgeLength, YearLength));
            var month = int.Parse(raw.Substring(index += YearLength, MonthLength));
            var day = int.Parse(raw.Substring(index + MonthLength, DayLength));
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
