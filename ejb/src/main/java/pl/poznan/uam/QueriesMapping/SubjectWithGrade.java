package pl.poznan.uam.QueriesMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectWithGrade {
    private int grade;
    private String subjectType;
    private String subjectName;

    //    private String lecturerNameAndSurname;
}
