using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;

namespace Challenge
{
    internal class Program
    {
        internal class ExitRequest : Exception { }
        internal class TooManyResults : Exception { }

        private static void Main()
        {
            var end = false;
            while (!end)
            {
                ListChallenges();
                try
                {
                    var t = ChooseChallenge();
                    var chal = t != null
                        ? Activator.CreateInstance(t) as Challenge
                        : throw new KeyNotFoundException();
                    chal?.Execute();
                }
                catch (KeyNotFoundException)
                {
                    Console.WriteLine("Challenge not found. Try again.");
                }
                catch (TooManyResults)
                {
                    Console.WriteLine("Search has multiple results, try again...");
                }
                catch (ExitRequest)
                {
                    end = true;
                }
                catch (Exception)
                {
                    Console.WriteLine("Error during execution");
                }

                if (!end) Console.ReadLine();
            }
        }

        private static IEnumerable<Type> GetChallenges() => Assembly.GetExecutingAssembly().GetTypes().Where(c => c.BaseType == typeof(Challenge));

        private static void ListChallenges()
        {
            var classes = GetChallenges();

            Console.WriteLine("Available:");
            foreach (var c in classes.Select(c => c.ToString()).OrderBy(c => c))
            {
                Console.WriteLine($" - {c}");
            }
            Console.WriteLine("Or type 'x' to exit...");
        }

        private static Type ChooseChallenge()
        {
            Console.WriteLine("Choose an entry: ");
            var input = Console.ReadLine();
            Console.WriteLine($"in: {input}");

            if (input == "x") throw new ExitRequest();

            var classes = GetChallenges();
            var challenge = classes.Where(c => c.ToString().Contains(input)).ToList();
            if (challenge.Count() > 1) throw new TooManyResults();

            return challenge.First();
        }
    }
}
