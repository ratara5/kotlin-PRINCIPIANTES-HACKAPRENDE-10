//y36
fun main(args: Array<String>) {

    val cineBoxPlayer=CineBoxPlayer()

    val movie1=Movie("Tuxedo", 80,true)
    val movie2=Movie("Tuxedo", 80,true)

    if(movie1.equals(movie2)){
        println("Same Movies")
    } else{
        println("Movie Differents ${movie1.hashCode()} and ${movie2.hashCode()}")
    }

    var trailerMonk=Trailer()

    //val media=Media("título",100,true,true) //No se puede crear un objeto o instancia de la clase Media, ya que es abstracta
    val movie3=Movie("FF2", 150, true) //Sí se puede crear objeto de clase hija (puede haber clases hijas abstractas?)
    val series3=Series("Monk",40,true,trailerMonk) //Sí se puede crear objeto de clase hija (puede haber clases hijas abstractas?)

    //y37
    val movie4=Movie("The craziest emperator",55,true)
    val movie5=Movie("Willie the bale",75,true)
    val movie6=Movie("Cars",85,true)
    val movie7=Movie("Godzilla",80,true)

    val series4=Series("Bigbang theory", 30, true)
    val series5=Series("The simpsons", 20, true)
    val series6=Series("Drake and Josh", 25, true)
    val series7=Series("Lost", 40, true)

    series3.playTrailer()

    val seriesList= listOf<Series>(series3,series4,series5,series6,series7) //No es necesario indicar el tipo de objeto de la lista entre <>. El listOf no se puede modificar
    println("The 1st item of the seriesList is ${seriesList[0]}")

    var mediaList=
        mutableListOf<Media>()//al crear clase abstracta, puedo crear lista de esa clase y agregar elementos de cualquier subclase. El mutableListOf sí se puede modificar
    mediaList.add(movie2)
    mediaList.add(series3)
    mediaList.add(movie3)
    mediaList.add(movie4)

    mediaList.add(series4)
    mediaList.add(movie5)

    addIfNotInList(mediaList,movie5) //agregar movie5 si no está en la lista
    addIfNotInList(mediaList,series6) //agregar series6 si no está en la lista

    mediaList.sort()
    showPlaylist(mediaList)

    println("The 5th item of the seriesList is ${mediaList[4]}")

    mediaList[1].play()
}

fun playMedia(media: Media){
    media.play()
}

fun showPlaylist(list: MutableList<Media>){
    println("")
    println("----Start Show list: mediaList----")
    for(item in list){
        println(item)
        //item.play() //Este comando reproducirá cada item
    }
    println("----End Show list: mediaList----")
    println("")
}

fun addIfNotInList(list:MutableList<Media>, media: Media){
    var p=""
    if(!list.contains(media)){
        list.add(media)
    }else{
        if(media is Movie) {
            p = "Movie"
        }else{
            p="Series"
        }
        println("$p ${media.name} is already in playlist")
    }
}



