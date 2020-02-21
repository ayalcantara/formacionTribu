object EjercicioCancion extends App {
  def readFile(fileName: String): Iterator[String] = io.Source.fromFile(fileName).getLines
  val ds: Array[Array[String]] = readFile("src/Resourses/leyendaDelHadaYelMago.txt")
    .map(_.split(" "))
    .toArray

  val tuplaLista = ds.flatMap(row => {
    row.map(cell => {
      cell.replaceAll("[^A-Za-z0-9]", "")
        .toLowerCase
    })
  }).groupBy(p => {
    p
  })
  tuplaLista.foreach(x => println(x._1 + "  " + x._2.length + " vez repetido"))


  //println(tuplaLista.maxBy(repeat=>(repeat._2.length)))

  val repeat = tuplaLista.maxBy(maximo =>(maximo._2.length))

  println("\nEn la cancion La Leyenda Del Hada y El Mago "+repeat._1 + " se repite " + repeat._2.length +" veces ")

}
