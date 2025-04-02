package com.valtech.project.QuizeService.vos;

import java.util.List;

public record QuestionVO(Long id, String questionText ,String option1,String option2,String option3,String answer,String topic, Long quizId ) {

	
	
}
