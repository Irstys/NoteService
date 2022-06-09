data class Note(
//идентификатор заметки
    val noteId: Int? = null,
//Заголовок заметки.
    var title: String,
//Текст заметки.
    var text: String,
//Идентификатор владельца заметки.
    val ownerId: Int? = null,
    //Дата создания заметки в формате Unixtime.
    val dateComment: Int? = null,

//Уровень доступа к заметке.
//Возможные значения:
//0 — все пользователи,
//1 — только друзья,
//2 — друзья и друзья друзей,
//3 — только пользователь.
    val privacy: Int=0,
//доступность заметки
    var availableNote: Boolean = false,

//возможность удаления
    var itIsDeleted: Boolean = false
//
)