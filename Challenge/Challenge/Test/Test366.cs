using Challenge.Challenges;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Linq;

namespace Challenge.Test
{
    [TestClass]
    public class Test366 : Challenge366
    {
        [DataTestMethod]
        [DataRow("ab", 2)]
        [DataRow("abc", 3)]
        [DataRow("abcd", 4)]
        public void TestGetOptions(string input, int expected)
        {
            Assert.AreEqual(expected, FindOptions(input).Count());
        }
    }
}
