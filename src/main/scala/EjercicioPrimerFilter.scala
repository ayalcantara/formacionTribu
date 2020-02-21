object EjercicioPrimerFilter extends App {
  val read = new EjemploReadCSV
  val dir: String = "src/Resourses/RealEstate.csv"
  read.exampleRead(dir)
}
class EjemploReadCSV() {
  def exampleRead(path: String): Unit = {
    val readCSV = io.Source.fromFile(path)
    val cols = readCSV.getLines().drop(1).map(_.split("|")).toArray
    val isFilter = cols.filter(x =>{x(3).matches("[1-4]")})
      .map(row =>{row(3)
        .toInt match {
        case 1 => "chico"
        case 2 => "mediano"
        case 3 => "grande"
        case 4 => "familiar"
        case _ =>
      }})
    isFilter.foreach(print(_, ""))
    readCSV.close
  }
}
