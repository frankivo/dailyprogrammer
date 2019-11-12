package nl.github.frankivo

import java.io.File
import java.net.URL

import scala.io.BufferedSource
import scala.sys.process._

import scala.language.postfixOps

object Helper {
  def getFile(url: String): BufferedSource = {
    getLocalFile(getFilename(url)) match {
      case Some(x) => x
      case _ => getRemoteFile(url)
    }
  }

  def getFilename(url: String): String = url.split("/").last

  def readFile(filename: String): BufferedSource = scala.io.Source.fromFile(filename)

  private def getLocalFile(fileName: String): Option[BufferedSource] = {
    val file = new File(fileName)
    if (!file.exists()) None
    else Some(scala.io.Source.fromFile(fileName))
  }

  private def getRemoteFile(url: String): BufferedSource = {
    val fileName = getFilename(url)
    fileDownloader(url)
    readFile(fileName)
  }

  private def fileDownloader(url: String): Unit = {
    new URL(url) #> new File(getFilename(url)) !!
  }

}
