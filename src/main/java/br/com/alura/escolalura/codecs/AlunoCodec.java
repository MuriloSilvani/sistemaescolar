package br.com.alura.escolalura.codecs;

import java.util.Date;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import br.com.alura.escolalura.models.Aluno;
import br.com.alura.escolalura.models.Curso;

public class AlunoCodec implements CollectibleCodec<Aluno> {

	private Codec<Document> codec;
	
	public AlunoCodec(Codec<Document> codec) {
		this.codec = codec;
	}
	
	public AlunoCodec() {
		
	}
	
	@Override
	public void encode(BsonWriter writer, Aluno aluno, EncoderContext encoder) {

		ObjectId id = aluno.getId();
		String nome = aluno.getNome();
		Date dataNascimento = aluno.getDataNascimento();
		Curso curso = aluno.getCurso();
		
		Document document = new Document();

		document.put("_id", id);
		document.put("nome", nome);
		document.put("dataNascimento", dataNascimento);
		document.put("curso", new Document("nome", curso.getNome()));
		
		codec.encode(writer, document, encoder);
	}

	@Override
	public Class<Aluno> getEncoderClass() {
		// TODO Auto-generated method stub
		return Aluno.class;
	}

	@Override
	public Aluno decode(BsonReader reader, DecoderContext decoderContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno generateIdIfAbsentFromDocument(Aluno aluno) {
		// TODO Auto-generated method stub
		return documentHasId(aluno) ? aluno.criarId() : aluno;
	}

	@Override
	public boolean documentHasId(Aluno aluno) {

		return aluno.getId() == null;
	}

	@Override
	public BsonValue getDocumentId(Aluno aluno) {
		// TODO Auto-generated method stub
		if(!documentHasId(aluno)){
			throw new IllegalStateException("Document sem id");
		}
		return new BsonString(aluno.getId().toHexString());
	}
	
	
}
