package subjects.services;

import org.springframework.stereotype.Service;

import subjects.DAOs.CommentsRepository;
import subjects.entities.Comments;

@Service
public class CommentsService {
	
	private CommentsRepository<Comments, Long> commentsDAO;
	
	public CommentsService(CommentsRepository<Comments, Long> commentsDAO) {
		super();
		this.commentsDAO = commentsDAO;
	}

	public Comments addComment(Comments comment) {
		return commentsDAO.save(comment);
	}
	
}
