class Member(var id: Long? = null, var name: String = null)

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Long): Member?
    fun findByName(name: String): Member?
    fun findAll(): List<Member>
}

class MemoryMemberRepository: MemberRepository {
    private companion object {
        val store = mutableMapOf<Long, Member>()
        var sequence: Long = 0L
    }

    override fun save(member: Member): Member{
        val memberId = ++sequence
        member.id = memberId
        store[memberId] = member
        return member
    }

    override fun findById(id: Long): Member? {
        val storeId: Member? = store[id]
        return storeId
    }

    override fun findByName(name: String): Member? {
        return store.values.filter{
            member -> member.name == name
        }.firstOrNull()
    }
}