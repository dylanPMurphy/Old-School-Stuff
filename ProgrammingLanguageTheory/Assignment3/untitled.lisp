#||
Dylan Murphy
CSI 311
Assignment 3 Functional Program

PL: LISP

This is my first time ever writing LISP code
||#

(defun m-length (list)
	(if (null list)
		0
		(+ 1 (m-length (cdr list)))
	)
)


(defun print-list (list)
	(if (not (null list))
		(progn
			(princ (car list))
			(print-list (cdr list))
		)
	)
)

(defun m-count (a list)
	(if (null list)
		0
		(progn
			(if(equal a (car list))
			  (+ 1 (m-count a (cdr list)))
			  (m-count a (cdr list))
			)
			
		)
	)
)

 


(m-count 0 (list 1 1 1 1 0 1 1 1 1 1 1 0 0 0 0 0 ))