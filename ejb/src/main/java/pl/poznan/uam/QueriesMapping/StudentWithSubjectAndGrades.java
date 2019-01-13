package pl.poznan.uam.QueriesMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithSubjectAndGrades {
    private String name;
    private String surname;
    private List<SubjectGroupShort> subjectDetails;
}
