"use client"; // Asegura que este archivo se interprete como un componente del cliente

import { useState } from 'react';
import { SelectValue, SelectTrigger, SelectItem, SelectContent, Select } from "@/components/ui/select";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { CardTitle, CardDescription, CardHeader, CardContent, CardFooter, Card } from "@/components/ui/card";

export function HomeComponent() {
  const [block, setBlock] = useState('');
  const [type, setType] = useState('');
  const [capacity, setCapacity] = useState('');
  const [name, setName] = useState('');
  const [errors, setErrors] = useState({});

  const isFormValid = () => {
    return block && type && capacity && name;
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (isFormValid()) {
      try {
        const aula = { block, type, capacity, name };
        const response = await axios.post('/api/aulas', aula);
        console.log('Aula agregada', response.data);
        setErrors({});
      } catch (error) {
        console.error('Error al agregar aula', error);
      }
    } else {
      setErrors({
        block: !block,
        type: !type,
        capacity: !capacity,
        name: !name
      });
      console.log('Por favor completa todos los campos');
    }
  };

  const handleNameChange = (e) => {
    const value = e.target.value;
    if (/^\d*$/.test(value)) { // Solo permite valores numéricos
      setName(value);
    }
  };

  const handleCapacityChange = (e) => {
    const value = e.target.value;
    if (/^\d*$/.test(value)) { // Solo permite valores numéricos
      setCapacity(value);
    }
  };

  return (
    <div key="1" className="w-full max-w-4xl mx-auto p-6 sm:p-8 bg-white rounded-lg shadow-lg dark:bg-gray-900">
      <h1 className="text-2xl font-bold mb-6 text-center dark:text-white">Reserva de Aulas UBICO</h1>
      <div className="mt-8">
        <div className="flex items-center justify-between mb-4">
          <h2 className="text-xl font-bold dark:text-white mt-8">Aulas Disponibles</h2>
        </div>
        <form className="grid grid-cols-1 md:grid-cols-4 gap-6 mt-4" onSubmit={handleSubmit}>
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="block">
              Bloque
            </label>
            <Select id="block" onValueChange={setBlock}>
              <SelectTrigger>
                <SelectValue placeholder="Selecciona un bloque" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="block1">Bloque 1</SelectItem>
                <SelectItem value="block2">Bloque 2</SelectItem>
                <SelectItem value="block3">Bloque 3</SelectItem>
                <SelectItem value="block4">Bloque 4</SelectItem>
              </SelectContent>
            </Select>
            {errors.block && <p className="text-red-500 text-sm">Este campo es requerido.</p>}
          </div>
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="type">
              Tipo de Aula
            </label>
            <Select id="type" onValueChange={setType}>
              <SelectTrigger>
                <SelectValue placeholder="Selecciona un tipo de aula" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="aulacomun">Aula Común</SelectItem>
                <SelectItem value="salonInformatica">Salón de Informática</SelectItem>
                <SelectItem value="laboratorio">Laboratorio</SelectItem>
              </SelectContent>
            </Select>
            {errors.type && <p className="text-red-500 text-sm">Este campo es requerido.</p>}
          </div>
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="capacity">
              Capacidad
            </label>
            <Input id="capacity" placeholder="Ingresa la capacidad" type="text" value={capacity} onChange={handleCapacityChange} />
            {errors.capacity && <p className="text-red-500 text-sm">Este campo es requerido y solo debe contener números.</p>}
          </div>
          <div className="space-y-2">
            <label className="text-sm font-medium text-gray-700 dark:text-gray-300" htmlFor="name">
              numero del Aula
            </label>
            <Input id="name" placeholder="Ingresa el numero del aula" type="text" value={name} onChange={handleNameChange} />
            {errors.name && <p className="text-red-500 text-sm">Este campo es requerido y solo debe contener números.</p>}
          </div>
          <div className="col-span-4 flex justify-end">
            <Button type="submit" variant="outline" disabled={!isFormValid()}>Agregar Aula</Button>
          </div>
        </form>
        {/* Aquí sigue el código de las tarjetas de aulas */}
      </div>
    </div>
  );
}
