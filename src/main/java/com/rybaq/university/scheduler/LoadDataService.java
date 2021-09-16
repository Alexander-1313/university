package com.rybaq.university.scheduler;

import com.rybaq.university.entity.Group;
import com.rybaq.university.entity.Student;
import com.rybaq.university.entity.Subject;
import com.rybaq.university.entity.Teacher;
import com.rybaq.university.repository.GroupRepository;
import com.rybaq.university.repository.StudentRepository;
import com.rybaq.university.repository.SubjectRepository;
import com.rybaq.university.repository.TeacherRepository;
import com.rybaq.university.util.StringConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoadDataService {

    private final GroupRepository groupRepository;

    @Scheduled(fixedRate = 124238572348L)
    public void loadData(){
        final int count = StringConstant.firstNames.size();

        for(int i = 0; i <= 500; i++){
            Student student =  new Student();
            student.setBirthday(LocalDate.now());
            student.setFirstName(StringConstant.firstNames.get((int)(Math.random() * count)));
            student.setLastName(StringConstant.lastNames.get((int)(Math.random() * count)));

            Teacher teacher = new Teacher();
            teacher.setFirstName(StringConstant.firstNames.get((int)(Math.random() * count)));
            teacher.setLastName(StringConstant.lastNames.get((int)(Math.random() * count)));

            Subject subject = new Subject();
            subject.setName(StringConstant.subjectsNames.get((int)(Math.random() * count)));

            Group group = new Group();
            group.setName(StringConstant.groupsNames.get((int)(Math.random() * count)));

            teacher.setSubject(subject);
            subject.setTeacher(teacher);
            student.setGroup(group);
            group.getStudents().add(student);
            subject.addGroup(group);

            groupRepository.save(group);
        }
        log.info("loading data was ended");
    }
}
