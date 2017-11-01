using System;
using System.Linq;

namespace Challenge.Challenges
{
    internal class Challenge338 : Challenge
    {
        private const string Inputs = "2017 10 30\r\n2016 2 29\r\n2015 2 28\r\n29 4 12\r\n570 11 30\r\n1066 9 25\r\n1776 7 4\r\n1933 1 30\r\n1953 3 6\r\n2100 1 9\r\n2202 12 15\r\n7032 3 26";

        public override void Execute()
        {
            foreach(var dt in Inputs.Split(new[] { "\r\n" }, StringSplitOptions.None)
                .Select(x => x.Split(' '))
                .Select(y => (Year: double.Parse(y[0]), Month: double.Parse(y[1]), Day: double.Parse(y[2]))))
            {
                var date = dt;

                if (date.Month < 3)
                {
                    date.Year--;
                    date.Month += 12;
                }

                var zellar = Zellar();
                var iso = ZellarToIso();
                Console.WriteLine($"{(Constants.Days)iso}");

                int Zellar() => (int)(date.Day + Math.Floor(13 * (date.Month + 1) / 5) + date.Year +
                                      Math.Floor(date.Year / 4) - Math.Floor(date.Year / 100) +
                                      Math.Floor(date.Year / 400)) % 7;
                int ZellarToIso() => ((zellar + 5) % 7) + 1;
            }
        }
    }
}
