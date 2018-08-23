using Challenge.Challenges;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;

namespace Challenge.Test
{
    [TestClass]
    public class Test366 : Challenge366
    {
        [DataTestMethod]
        [DataRow("a", 1)]
        [DataRow("ab", 2)]
        [DataRow("abc", 3)]
        [DataRow("abcd", 4)]
        public void TestGetOptions(string input, int expected) => 
            Assert.AreEqual(expected, GetOptions(input).Count());

        [DataTestMethod]
        [DataRow("test", "tst", true)]
        [DataRow("aap", "pa", false)]
        public void TestFunnel(string haystack, string needle, bool expected) =>
            Assert.AreEqual(expected, Funnel(haystack, needle));
    }
}
