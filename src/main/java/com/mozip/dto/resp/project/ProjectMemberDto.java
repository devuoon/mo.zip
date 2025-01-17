package com.mozip.dto.resp.project;

import lombok.Data;

@Data
public class ProjectMemberDto {
    // 프로젝트 참여자 데이터(작성자, 참여자 혼용 가능)
    private int id;
    private String username;
    private String position;
    private int career;
    private String profileImageUrl;
    private String createdAt;

    public ProjectMemberDto(int id, String username, String position, int career, String profileImageUrl, String createdAt) {
        this.id = id;
        this.username = username;
        this.position = position;
        this.career = career;
        this.profileImageUrl = profileImageUrl;
        this.createdAt = createdAt;
    }
}
