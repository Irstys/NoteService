class NoteService {
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()

    private var nextId: Int = 1

    fun add(userId: Int, title: String, text: String): Note {
        val note = Note(nextId++, title, text)
        notes += note
        return note
    }

    fun createComment(noteId: Int, message: String): Comment {
        val comment = Comment(nextId++, noteId, message)
        comments += comment
        return comment
    }

    fun deleteComment(commentId: Int?) {
        getCommentById(commentId).itIsDeleted = true
    }

    fun getById( noteId: Int): Note {
        return notes.firstOrNull{it.noteId ==  noteId} ?:throw NoteNotFoundException()
    }

    fun getCommentById(commentId: Int): Comment {
        return comments.firstOrNull{it.commentId == commentId} ?: throw CommentNotFoundException()
    }

    fun delete(id: Int) {
        val foundPost = getById(id)
        foundPost.itIsDeleted = true
    }

    fun edit(note: Note) {
        val foundPost = note.noteId?.let { getById(it) }
        foundPost.text = note.text
        foundPost.title = note.title
    }

    fun get(noteIds: List<Int>, userId: Int, offset: Int = 0, count: Int = 20): List<Note> {
        val res = mutableListOf<Note>()
        var offSetCount = offset
        for(note in notes) {
            if (noteIds.contains(note.noteId) && (userId == note.ownerId)) {
                if (offSetCount > 0) offSetCount-- else res += note
            }
            if (res.count() == count) return res
        }
        return res
    }

    fun getComments(commentId: Int): List<Comment> {
        val res = mutableListOf<Comment>()
        for(comment in comments) {
            if (comment.commentId == commentId) {
                res += comment
            }
        }
        return res
    }
}