package pl.poznan.uam.QueriesMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradesFromSubject {
    private String name;
    private String surname;
    private int grade;
//    private String subjectName;
}

