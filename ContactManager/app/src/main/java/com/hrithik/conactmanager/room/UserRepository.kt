package com.hrithik.conactmanager.room

class UserRepository(private val dao: UserDao) {

    val users = dao.getAllUsers()

    suspend fun insert(user: User): Long {
        return dao.insertUser(user)
    }

    suspend fun delete(user: User) {
        return dao.deleteUser(user)
    }

    suspend fun update(user: User) {
        return dao.updateUser(user)
    }
}