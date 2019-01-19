package pl.poznan.uam.QueriesMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithSubjectAndGrades {
    private String name;
    private String surname;
    private String email;
    private List<SubjectWithGrade> subjectDetails;
}
