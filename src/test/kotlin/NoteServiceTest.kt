import org.junit.Test

import org.junit.Assert.*
private val NoteService = NoteService()

class NoteServiceTest {

    @Test
    fun add() {
        val note = NoteService.add(0, "Test note", "Lorem ipsum...")
        assertNotEquals(0, note.noteId)
    }

    @Test
    fun createComment() {
        val note = NoteService.add(0, "Test note", "Lorem ipsum...")
        NoteService.createComment(note.noteId, "Comment")
        assertEquals(NoteService.getComments(note.noteId).count(), 1)
    }

    @Test
    fun deleteComment() {
        val note = NoteService.add(0, "Test note", "Lorem ipsum...")
        val comment = NoteService.createComment(note.noteId, "Test comment")

        NoteService.deleteComment(comment.commentId)
        assertTrue(comment.itIsDeleted)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getById() {
        NoteService.getById(5)
    }

    @Test
    fun delete() {
        val note = NoteService.add(0, "Test note", "Lorem ipsum...")
        NoteService.delete(note.noteId)
        assertTrue(note.itIsDeleted)
    }

    @Test
    fun edit() {
        val note1 = NoteService.add(0, "Test note", "Lorem ipsum...")
        val note2 = Note(note1.noteId, 0, "New note", "Text changed")
        NoteService.edit(note2)
        assertEquals(note1.text, "Text changed")

    }

    @Test
    fun get() {
        val note1 = NoteService.add(0, "Test note", "Lorem ipsum...")
        val note2 = NoteService.add(0, "Test note", "Lorem ipsum...")
        val note3 = NoteService.add(0, "Test note", "Lorem ipsum...")

        val notes = NoteService.get(listOf<Int>(note1.noteId, note2.noteId, note3.noteId), 0, 0, 2)
        assertEquals(2, notes.count())

    }

    @Test
    fun getComments() {
        val note = NoteService.add(0, "Test note", "Lorem ipsum...")
        NoteService.createComment(note.noteId, "Test comment 1")
        NoteService.createComment(note.noteId, "Test comment 2")
        NoteService.createComment(note.noteId, "Test comment 3")
        assertEquals(3, NoteService.getComments(note.noteId).count())
    }
}
