package io.dustin.api.router.user.model

import io.dustin.common.constraint.EnumCheck
import io.dustin.domain.user.model.User
import io.dustin.domain.user.model.code.Job
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateUser(
        @field:NotNull(message = "유저 이름이 누락되었습니다. 최소 한 글자 이상이어야 합니다.")
        @field:NotBlank(message = "유저의 이름에 빈 공백은 허용하지 않습니다.")
        val name: String,
        @field:NotNull(message = "직업 정보가 누락되었습니다.")
        @field:EnumCheck(enumClazz = Job::class, permitNull = true, message = "job 필드는 Junsa, Dojuk, Mabupsa, Gungsu 만 가능합니다.")
        val job: String,
) {
    fun toEntity(): User {
        return User(name = name, job = Job.valueOf(job.uppercase()))
    }
}