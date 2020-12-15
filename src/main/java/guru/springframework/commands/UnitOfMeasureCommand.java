package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;

    @NotBlank
    @Size(min = 0,max = 255)
    private String description;
}
