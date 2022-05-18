package Ejercicio7Practico2;

import java.util.ArrayList;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;
	private int size = 0;

	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.size++;
	}
	
	public void add(Integer newValue) {
		if (this.value == null) 
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null) {
					this.left = new Tree(newValue);
					this.size++;
				}
				else {
					this.left.add(newValue);
					this.size++;
				}
			} else if (this.value < newValue) {
				if (this.right == null) {
					this.right = new Tree(newValue);
					this.size++;
				}
				else {
					this.right.add(newValue);
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
			if (this.value == valor) {
				return true;
			}
			else {
				if (this.value < valor && right!=null) {
					return this.right.hasElement(valor);
				}
				else if (this.value > valor && left!=null) {
						return this.left.hasElement(valor);
					}
				
				}
			return false;
		}
	
	public boolean isEmpty() {
		return this.getSize()==0;
	}

	//imprime raiz despues rama izquierda y despues rama derecha
	public void printPreOrder() {
		System.out.print(this.value + " ");
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
		if (this.value == null)
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
		System.out.print(this.value);
		
	}

	public void printInOrder() {
		if (this.left!=null)
			this.left.printInOrder();
		if (this.value!=null)
			System.out.print(this.value + " ");
		if (this.right!=null)
			this.right.printInOrder();
		}
	
	public int getMaxElem() {
		if (this.right!=null) {
			return this.right.getMaxElem();
		}
		return this.value;
	}
	
	private ArrayList<Integer>getElemAtLevel(int levelactual,int lev) {
		ArrayList<Integer>ElementsLevel= new ArrayList<Integer>();
		
		if (levelactual == lev) {
			ElementsLevel.add(this.value);
		}
		if (this.left!=null) {
			ElementsLevel.addAll(this.left.getElemAtLevel(levelactual+1,lev));
		}
		if (this.right!=null) {
			ElementsLevel.addAll(this.right.getElemAtLevel(levelactual+1,lev));
		}
		
		return ElementsLevel;
	}
	
	public ArrayList<Integer> getElemAtLevel(int lev) {
		int levelactual=0;
		return this.getElemAtLevel(levelactual,lev);
	}
	
	public ArrayList<Integer> getFrontera(){
		ArrayList<Integer>ElementosHojas = new ArrayList<Integer>();
		if (this.left==null && this.right==null) {
			ElementosHojas.add(this.value);
		}else {
			if (this.left!=null) {
				ElementosHojas.addAll(this.left.getFrontera());
			}
			if (this.right!=null) {
				ElementosHojas.addAll(this.right.getFrontera());
			}
		}
		return ElementosHojas;
	}

	//rama mas larga
	public ArrayList<Integer> getLongestBranch(){
			ArrayList<Integer> aux= new ArrayList<Integer>();
			ArrayList<Integer> leftList= new ArrayList<Integer>();
			ArrayList<Integer> rightList= new ArrayList<Integer>();
		
			if (this!=null && this.left==null && this.right==null) {
				aux.add(this.value);
			}
			if (this.left!=null) {
				leftList.add(this.value);
				leftList.addAll(this.left.getLongestBranch());
				
			}
			if (this.right!=null) {
				rightList.add(this.value);
				rightList.addAll(this.right.getLongestBranch());
				
			}
		
			if (leftList.size()>rightList.size()) {
				aux.addAll(leftList);
			}else aux.addAll(rightList);
		return aux;
	}
	
	//altura del arbol
	public int getHeight() {
		int levelleft=0;
		int levelright=0;
		if (this.left!=null ) {
			levelleft= left.getHeight()+1;
		}
		if (this.right!=null ) {
			levelright= right.getHeight()+1;
		}
		int max= Math.max(levelleft,levelright);
	return max;
	}
	
	
	
	public boolean delete(int element) {
		
		//borra cuando es raiz o hoja 
		if ( this.value== element && this.esHoja() ) {
			this.setValue(null);
			this.size--;
			return true;
		}
		else {
			// borrar si tiene un hijo 
			if (this.tieneHijos()) {
				//busca por izquierda el elemento a borrar
				if (element < this.value) {
					if (element == this.left.getValue()) {
						this.left=deleteCenter(this.left);
						return true;
					}
					this.left.delete(element);
				}
				
				if (element>this.value) {
					if (element == this.right.getValue()) {
						this.right=deleteCenter(this.right);
						return true;
					}
					this.right.delete(element);
				}
				else 
					if (this.tieneHijos()|| this.left!=null) {
						 Integer NMDSI = this.elementoMayorIzquierdos();//devuelve el mayor de los menores del subarbol izquierda;
						 this.delete(NMDSI);
						 this.setValue(NMDSI);
						 return true;
					}else { 
						Integer NMISD= this.elementoMenorDerechos();// devuelve el menor de los mayores subarbol derecha;
						this.delete(NMISD);
						this.setValue(NMISD);
						return true;
						
					}
			}
		}
			return false;
		
	}
	
	public Tree deleteCenter(Tree posActual) {
		if (posActual.esHoja()){
			posActual=null;
		}else if (posActual.tieneHijos()){
				int NMDSI = posActual.elementoMayorIzquierdos();
				posActual.delete(NMDSI);
				posActual.setValue(NMDSI);
				}else  {
					if (posActual.tieneHijoDerecho()) {
							posActual=posActual.right;
					}
					
					if (posActual.tieneHijoIzquierdo()) {
						posActual=posActual.left;
					}
				}
		
		return posActual;
	}
	
	public boolean esHoja() {
		return this.value!=null && this.left==null || this.right==null;
	}
	
	public boolean tieneHijos() {
		return this.left!=null && this.right!=null;
	}
	public boolean tieneHijoDerecho() {
		return this.right!=null;
	}
	
	public boolean tieneHijoIzquierdo() {
		return this.left!=null;
	}
	
	public int elementoMayorIzquierdos() {
		int mayor=-1;
		if (this.left!=null) {
			mayor= this.left.getMaxElem();
		}
		return mayor;
	}
	public int elementoMenorDerechos() {
		int menor=-1;
		if (this.right!=null) {
			menor =this.right.getMinElem();
		}
		return menor;
	}
	
	private int getMinElem() {
		if (this.left!=null) {
			return this.left.getMinElem();
		}
		return this.value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Tree [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}