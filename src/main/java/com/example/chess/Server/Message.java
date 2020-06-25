package com.example.chess.Server;

import com.example.chess.Piece.rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private String userId;
    private String message;
    private String start;
    private com.example.chess.Piece.rule rule;
}
