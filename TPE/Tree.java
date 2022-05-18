
public class Tree {
	
	private Libro libro;
	private Tree left;
	private Tree right;
	private int size = 0;
	
	public Tree() {
		this.libro=null;
		this.left=null;
		this.right=null;
	}
	
	public Tree(Libro l) {
		this.libro=l;
		this.left = null;
		this.right = null;
		this.size++;
	}
	
	public void addLibro(Libro newLibro) {
		if (this.libro == null) 
			this.libro = newLibro;
		else {
			if (this.libro.getId() > newLibro.getId()) {
				if (this.left == null) {
					this.left = new Tree(newLibro);
					this.size++;
				}
				else {
					this.left.addLibro(newLibro);
					this.size++;
				}
			} else if (this.libro.getId() < newLibro.getId()) {
				if (this.right == null) {
					this.right = new Tree(newLibro);
					this.size++;
				}
				else {
					this.right.addLibro(newLibro);
					this.size++;
				}
					
			}
		}
	}
	
	//Complejidad O(1) no tiene complejidad ya que devuelve la raiz del arbol.
		public Tree getRoot() {
			return this;
		}
		
		// O(h) donde h es la altura, en el peor de los casos debe recorrer la rama mas baja
		public boolean hasElement(int valor) {
				if (this.libro.getId() == valor) {
					return true;
				}
				else {
					if (this.libro.getId() < valor && right!=null) {
						return this.right.hasElement(valor);
					}
					else if (this.libro.getId() > valor && left!=null) {
							return this.left.hasElement(valor);
						}
					
					}
				return false;
			}
		
		public boolean isEmpty() {
			return this.getSize()==0;
		}

		private int getSize() {
			return this.size;
		}

		//imprime raiz despues rama izquierda y despues rama derecha
		public void printPreOrder() {
			System.out.print(this.libro + " ");
			if (this.left!=null){
				this.left.printPreOrder();
			}else
				System.out.print("- ");
			if (this.right!=null) {
				this.right.printPreOrder();
			}else 
				System.out.print("- ");
		}
		public void printPostOrder() {
			if (this.libro == null)
				System.out.print("-");
			if (this.left!=null){
				this.left.printPostOrder();
				System.out.print("-");
			}
			System.out.print("-");
			if (this.right!=null) {
				this.right.printPostOrder();
				System.out.print("-");
				
			}
			System.out.print(this.libro);
			
		}

		public void printInOrder() {
			if (this.left!=null)
				this.left.printInOrder();
			if (this.libro!=null)
				System.out.println(this.libro + " ");
			if (this.right!=null)
				this.right.printInOrder();
			}
		
}
