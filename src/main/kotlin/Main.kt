enum class SongGenre {
    POP,
    ROCK,
    RAP,
    JAZZ,
    SWING
}

data class Artist(
    val nameOfArtist: String
)
data class Song(
    val nameOfSong: String,
    val songGenre: SongGenre,
    val artist: Artist
)
data class Album(
    val nameOfAlbum: String,
) {
    val listOfSongs: MutableList<Song> = mutableListOf()
    fun addSong(song: Song) {
        this.listOfSongs.add(song)
    }
}

interface Playlist {
    fun addSong(song: Song)
    fun addAlbum(album: Album)
    fun shuffle()
}

class PlayListImpl : Playlist {
    private val playlist: MutableList<Song> = mutableListOf()

    override fun addSong(song: Song) {
        this.playlist.add(song)
    }
    override fun addAlbum(album: Album) {
        this.playlist.addAll(album.listOfSongs)
    }
    override fun shuffle() {
        this.playlist.shuffle()
    }
    override fun toString(): String{
        return "\n$playlist"
    }
}

fun main() {
    val song1 = Song("Lost in the Rhythm", SongGenre.SWING,Artist("Jamie Berry"))
    val song2 = Song("Sway", SongGenre.JAZZ,Artist("Dean Martin"))
    val song3 = Song("Кукла Колдуна", SongGenre.ROCK,Artist("Король и Шут"))
    val song4 = Song("Song of Joy", SongGenre.ROCK, Artist("Nick Cave and the Bad Seeds"))
    val song5 = Song("Henry Lee", SongGenre.ROCK, Artist("Nick Cave and the Bad Seeds"))
    val song6 = Song("Red Right Hand", SongGenre.ROCK, Artist("Nick Cave and the Bad Seeds"))
    val song7 = Song("Buona Sera", SongGenre.JAZZ,Artist("Dean Martin"))
    val song8 = Song("In Napoli", SongGenre.JAZZ,Artist("Dean Martin"))
    val song9 = Song("Believer", SongGenre.POP,Artist("Imagine Dragons"))
    val song10 = Song("Still D.R.E.", SongGenre.RAP,Artist("Dr. Dre"))

    val album1 = Album("Murder Ballads")
    album1.addSong(song4)
    album1.addSong(song5)
    album1.addSong(song6)

    val album2 = Album("Best Of Dean Martin")
    album2.addSong(song2)
    album2.addSong(song7)
    album2.addSong(song8)

    val playList = PlayListImpl()
    playList.addSong(song1)
    playList.addSong(song3)
    playList.addSong(song9)
    playList.addSong(song10)
    playList.addAlbum(album1)
    playList.addAlbum(album2)

    println ("1st playlist")
    playList.shuffle()
    println(playList)
    println("2nd playlist")
    playList.shuffle()
    println(playList)
}