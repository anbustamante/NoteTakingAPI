package com.anbustamante.notetakingapi.dto;

import com.anbustamante.notetakingapi.model.Notes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GETNotesDTO {
    private List<Notes> notes;
}
