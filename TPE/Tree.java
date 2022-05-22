
public class Tree {
	
	private Genero genero;
	private Tree left;
	private Tree right;
	private int size = 0;
	
	public Tree() {
		this.genero=null;
		this.left=null;
		this.right=null;
	}
	
	public Tree(Genero g) {
		this.genero=g;
		this.left = null;
		this.right = null;
		this.size++;
	}
	
	public void addGenero(Genero newGenero) {
		if (this.genero == null) 
			this.genero = newGenero;
		else {
			if (this.genero.getNombre().compareTo(newGenero.getNombre())>0) {
				if (this.left == null) {
					this.left = new Tree(newGenero);
					this.size++;
				}
				else {
					this.left.addGenero(newGenero);
					this.size++;
				}
			} else if (this.genero.getNombre().compareTo(newGenero.getNombre())<0) {
				if (this.right == null) {
					this.right = new Tree(newGenero);
					this.size++;
				}
				else {
					this.right.addGenero(newGenero);
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
		public boolean hasElement(String valor) {
				if (this.genero.getNombre().equals(valor)) {
					return true;
				}
				else {
					if (this.genero.getNombre().compareTo(valor)<0 && right!=null) {
						return this.right.hasElement(valor);
					}
					else if (this.genero.getNombre().compareTo(valor)>0 && left!=null) {
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
			System.out.print(this.genero + " ");
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
			if (this.genero == null)
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
			System.out.print(this.genero);
			
		}

		public void printInOrder() {
			if (this.left!=null)
				this.left.printInOrder();
			if (this.genero!=null)
				System.out.println(this.genero + " ");
			if (this.right!=null)
				this.right.printInOrder();
			}
		
}
