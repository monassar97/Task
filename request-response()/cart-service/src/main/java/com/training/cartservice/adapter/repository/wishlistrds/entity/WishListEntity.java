package com.training.cartservice.adapter.repository.wishlistrds.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Builder
public class WishListEntity {
    @Id
    private String wishListId;
    private String userId;
}
