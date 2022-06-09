data class Comment(
    //идентификатор комментария
    val commentId: Int? = null,
    //Идентификатор автора комментария
    val userId: Int? = null,
    //идентификатор заметки
    val noteId: String,
    //Идентификатор владельца заметки.
    val ownerId: Int? = null,
    //Дата создания комментария в формате Unixtime.
    val dateComment: Int? = null,
    //Текст комментария.
    val message: String,
    //Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий (не передаётся, если комментарий не является ответом).
    val replyTo: Int? = null,
    //Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового комментария.
    val guid: String? = null,
    //возможность удаления
    var itIsDeleted: Boolean = false,
    //доступность комментария.
    var availableСomment: Boolean = false,
)