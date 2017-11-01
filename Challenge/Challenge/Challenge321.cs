using System;
using System.Collections.Generic;
using System.Linq;

namespace Challenge
{
    internal class Challenge321 : Challenge
    {
        private readonly List<string> _inputs = new List<string> {"00:00", "01:30", "12:05", "14:01", "20:29", "21:00"};

        public override void Execute()
        {
            foreach (var t in _inputs.Select(x => x.Split(':'))
                .Select(y => (Hour: int.Parse(y[0]), Minute: int.Parse(y[1]))))
            {
                var time = t;

                var d = time.Hour <= 12 ? "am" : "pm";

                if (time.Hour > 12) time.Hour -= 12;
                if (time.Hour == 0) time.Hour = 12;

                var h = ((Constants.Numbers) time.Hour).ToString().ToLower();

                var msg = $"It's {h}";
                if (time.Minute > 0) msg += $" {time.Minute}";
                msg += $" {d}";

                Console.WriteLine(msg);
            }
        }
    }
}
