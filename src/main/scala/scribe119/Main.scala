package scribe119

import java.io.File
import java.nio.file.Paths
import scribe.Logger
import scribe.writer.FileWriter
import scribe.writer.file.LogPath

object Main extends App {

  if (new File("logs/app.log").delete()) {
    println("Previous 'logs/app.log' deleted.")
  }
  Logger.root.withHandler(
    writer = FileWriter().path(
      LogPath.simple(directory = Paths.get("correct-logs"))
    )
  )

  if (new File("logs/app.log").exists()) {
    println("New `logs/app.log` file found. Test failed.")
  } else {
    println("Test passed.")
  }

}
